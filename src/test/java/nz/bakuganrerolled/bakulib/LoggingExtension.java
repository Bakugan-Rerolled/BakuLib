package nz.bakuganrerolled.bakulib;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;
import java.util.Optional;

/**
 * A JUnit extension to provide logging before and after tests.
 *
 * @author Matt Eden
 * @version 0.1
 * @since 0.1
 * */
public class LoggingExtension implements BeforeEachCallback, AfterEachCallback {

    static final Logger LOG = LogManager.getLogger();

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        Optional<Method> test = extensionContext.getTestMethod();
        test.ifPresent(method -> LOG.info("Running test: " + method.getName()));
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        boolean testResult = extensionContext.getExecutionException().isPresent();
        Optional<Method> test = extensionContext.getTestMethod();
        test.ifPresent(method -> LOG.info(String.format("Result of [%s] is: %s",
                method.getName(), testResult ? "FAIL" : "PASS")));
    }
}
