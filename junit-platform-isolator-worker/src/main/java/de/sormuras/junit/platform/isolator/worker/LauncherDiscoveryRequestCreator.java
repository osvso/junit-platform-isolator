package de.sormuras.junit.platform.isolator.worker;

import static java.util.stream.Collectors.toSet;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClasspathRoots;
import static org.junit.platform.launcher.TagFilter.includeTags;
import static org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder.request;

import de.sormuras.junit.platform.isolator.Configuration;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;

class LauncherDiscoveryRequestCreator {

  LauncherDiscoveryRequest create(Configuration.Discovery configuration) {
    LauncherDiscoveryRequestBuilder requestBuilder = request();

    // selectors
    checkAsPaths(configuration.selectedClasspathRoots)
        .ifPresent(roots -> requestBuilder.selectors(selectClasspathRoots(roots)));

    // filters
    checkStrings(configuration.filterTagsIncluded)
        .ifPresent(tags -> requestBuilder.filters(includeTags(tags)));

    // configuration parameters
    requestBuilder.configurationParameters(configuration.parameters);

    return requestBuilder.build();
  }

  private static Optional<Set<Path>> checkAsPaths(Set<String> strings) {
    if (strings == null || strings.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(strings.stream().map(Paths::get).collect(toSet()));
  }

  private static <T extends Collection<String>> Optional<T> checkStrings(T strings) {
    if (strings == null || strings.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(strings);
  }
}
