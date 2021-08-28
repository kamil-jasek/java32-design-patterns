package pl.sda.domain;

import java.time.Instant;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class PremiumStatus {

    private final boolean active;
    private final Instant expireAt;

    public PremiumStatus(boolean active, Instant instant) {
        this.active = active;
        this.expireAt = requireNonNull(instant);
    }

    public boolean isActive() {
        return active;
    }

    public Instant getExpireAt() {
        return expireAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PremiumStatus that = (PremiumStatus) o;
        return active == that.active && expireAt.equals(that.expireAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(active, expireAt);
    }
}
