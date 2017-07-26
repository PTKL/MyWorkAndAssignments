package stories.cs2800;

/**
 * The Enum ItemType used to distinguish the four kinds of item in the system.
 * All items are the same internally (except for being Single or Aggregate)
 * Externally, they are stored in lists keyed by the enum.
 *
 * @author Professor David Cohen
 */
public enum ItemType {

    /** A developer. */
    DEVELOPER,
    /** A story. */
    STORY,
    /** A project. */
    PROJECT,
    /** A story developer. */
    STORY_DEVELOPER
}
