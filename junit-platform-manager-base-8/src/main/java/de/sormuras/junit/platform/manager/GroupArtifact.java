package de.sormuras.junit.platform.manager;

import java.util.function.Function;

/** Maven group and artifact coordinates. */
enum GroupArtifact {
  JUNIT_JUPITER_API("org.junit.jupiter", "junit-jupiter-api", "JUNIT_JUPITER"),

  JUNIT_JUPITER_ENGINE("org.junit.jupiter", "junit-jupiter-engine", "JUNIT_JUPITER"),

  JUNIT_PLATFORM_COMMONS("org.junit.platform", "junit-platform-commons", "JUNIT_PLATFORM"),

  JUNIT_PLATFORM_CONSOLE("org.junit.platform", "junit-platform-console", "JUNIT_PLATFORM"),

  JUNIT_PLATFORM_LAUNCHER("org.junit.platform", "junit-platform-launcher", "JUNIT_PLATFORM"),

  JUNIT_VINTAGE_ENGINE("org.junit.vintage", "junit-vintage-engine", "JUNIT_VINTAGE");

  private final String artifact;
  private final String group;
  private final String versionName;

  GroupArtifact(String group, String artifact, String versionBaseName) {
    this.group = group;
    this.artifact = artifact;
    this.versionName = versionBaseName + "_VERSION";
  }

  public String getArtifact() {
    return artifact;
  }

  public String getGroup() {
    return group;
  }

  public Version getVersion() {
    return Version.valueOf(versionName); // lazy
  }

  public String toString() {
    return getGroup() + ':' + getArtifact();
  }

  public String toString(Function<Version, String> version) {
    return toString() + ':' + version.apply(getVersion());
  }
}
