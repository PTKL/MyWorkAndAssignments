/**
 * This system provides a view of projects, stories and developers in an
 * active company.
 * It allows the view to be associated with some kind of persistent storage.
 *
 * Every developer is allowed to work on many stories.
 * Any project involves many stories.
 * Any story can be worked on by many developers.
 *
 * Each develop has an hourly cost.  Each story has an expected cost, as does
 * each project.
 * The system allows us to see who is working with whom, who is working on a
 * project or a story.
 * It also allows us to see the links between stories, developers and projects.
 * Finally we can see the total cost so far of a developer, a story, or a
 * project.
 *
 * Every project, developer or story has a name and this must be unique in
 * the whole system as it is used as the key for persistent storage.
 *
 * It has been built as part of the Software Engineering strand at
 * Royal Holloway, University of London for teaching purposes.
 *
 * @author Professor David Cohen
 *
 */
package stories.cs2800;

