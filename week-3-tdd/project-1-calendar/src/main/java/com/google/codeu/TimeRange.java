package com.google.codeu;

public final class TimeRange {
  public final long start;
  public final long end;

  public TimeRange(long start, long end) {
    assert start >= 0;
    assert end >= 0;
    assert end >= start;

    this.start = start;
    this.end = end;
  }

  public long duration() {
    return end - start;
  }

  /**
   * Check if two time ranges overlap with each other. This means that at least some part of one
   * range falls within the bounds of another range.
   */
  public boolean overlaps(TimeRange other) {
    return this.contains(other.start)
        || this.contains(other.end)
        || other.contains(this.start)
        || other.contains(this.end);
  }

  /**
   * Check if this range completely contains another range. This means that |other| is a subset of
   * the bounds of |this|. This is an inclusive bounds, meaning that if two ranges are the same,
   * they are considered containing each other.
   */
  public boolean contains(TimeRange other) {
    return start <= other.start && end >= other.end;
  }

  /**
   * Check if a point falls with the bounds defined by |this|. This is an inclusive bounds, meaning
   * that if the point is the same as the start or end, it falls within the bounds.
   */
  public boolean contains(long point) {
    return start <= point && end >= point;
  }

  @Override
  public boolean equals(Object other) {
    return other instanceof TimeRange && equals(this, (TimeRange) other);
  }

  @Override
  public int hashCode() {
    return Long.hashCode(start ^ end);
  }

  @Override
  public String toString() {
    return String.format("[%d, %d]", start, end);
  }

  private static boolean equals(TimeRange a, TimeRange b) {
    return a.start == b.start && a.end == b.end;
  }
}