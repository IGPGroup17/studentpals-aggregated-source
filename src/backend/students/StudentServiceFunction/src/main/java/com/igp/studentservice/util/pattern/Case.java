package com.igp.studentservice.util.pattern;

import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

public class Case<I, O> {

    private static final Predicate<Boolean> TRUTH_PREDICATE = t -> t.equals(true);

    private Predicate<I> matcher;

    private O output;

    private Set<Guard> guards;

    private Case(Predicate<I> matcher) {
        this.matcher = matcher;
    }

    /**
     * Only intended for default case used internally (external sources shouldn't be able to access this!!)
     */
    private Case(O output) {
        this.output = output;
    }

    public static <I, O> Case<I, O> constant(I constant) {
        return new Case<>((t) -> Objects.deepEquals(t, constant));
    }


    public static <I, O> Case<I, O> of(Predicate<I> matcher) {
        return new Case<>(matcher);
    }

    static <I, O> Case<I, O> defaultCase(O output) {
        return new Case<>(output);
    }

    public Case<I, O> then(O output) {
        this.output = output;
        return this;
    }

    public Case<I, O> andIf(Guard guard) {
        guards.add(guard);
        return this;
    }

    public Case<I, O> withGuards(Guard... guards) {
        return withGuards(Set.of(guards));
    }

    public Case<I, O> withGuards(Set<Guard> guards) {
        this.guards = guards;
        return this;
    }

    public boolean test(I input) {
        return matcher.test(input) && checkGuards();
    }

    public O getOutput() {
        return output;
    }

    private boolean checkGuards() {
        return guards.stream().map(Guard::check).allMatch(TRUTH_PREDICATE);
    }
}
