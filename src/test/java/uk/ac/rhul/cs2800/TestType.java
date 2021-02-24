package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import org.junit.jupiter.api.Test;

class TestType {

  // Test 1
  // Like the TestSymbolEnum class, we are using a raw type of
  // hashset so suppresswarnings were added. Added enum types
  // to add to hashset.
  @SuppressWarnings({"static-access", "unchecked", "rawtypes"})
  @Test
  void test() {
    HashSet settoStoreType = new HashSet();
    for (uk.ac.rhul.cs2800.Type type : Type.values()) {

      settoStoreType.add(type.values());
    }
    assertEquals(settoStoreType.size(), 4, "4 types of enums so for items in set.");
  }
}
