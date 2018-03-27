package edu.psu.ist411.compute;

/**
 * The second interface needed for the compute engine is the Task interface,
 * which is the type of the parameter to the executeTask method in the Compute
 * interface. The compute.Task interface defines the interface between the
 * compute engine and the work that it needs to do, providing the way to start
 * the work. Here is the source code for the Task interface:
 *
 * @param <T> represents the result type of the task's computation. This
 * interface's execute method returns the result of the computation and thus its
 * return type is T.
 */
public interface Task<T> {

   /**
    * The Compute interface's executeTask method, in turn, returns the result of
    * the execution of the Task instance passed to it. Thus, the executeTask
    * method has its own type parameter, T, that associates its own return type
    * with the result type of the passed Task instance.
    *
    * @return the result
    */
   T execute();
}
