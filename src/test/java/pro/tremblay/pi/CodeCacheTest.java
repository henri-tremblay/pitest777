package pro.tremblay.pi;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CodeCacheTest {

    private final CodeCache cache = new CodeCache();

    @Test
    public void findById_notFoundWhenEmpty() {
        assertThat(cache.findById("a")).isNull();
    }
}
