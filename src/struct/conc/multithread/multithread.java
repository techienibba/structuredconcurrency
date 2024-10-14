package struct.conc.multithread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.ShutdownOnFailure;

/* Issues solved with multi-threading->Sructured Concurrency
 * Thread Chaining
 * Exceptions Handling Mechanism
 * Resource Cleanup
 * Thread Management
 * ExecutorService
 * CompletableFuture -> requires Executor for Exceptions Handling
 * Virtual threads Creation
 * Scope management along with execution
 */
public class multithread 

{
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
	
	
	try(ShutdownOnFailure scope = new StructuredTaskScope.ShutdownOnFailure())
	{
		var creditcardscope = scope.fork(() ->{
			   System.out.println("Credit Card processing thread" + 0/0 + Thread.currentThread().getName());
				  return "First thread";
				
		});
		
		var loanapplication = scope.fork(() ->{
			   System.out.println("Loan application processing thread" + Thread.currentThread().getName());
			   return "Second Thread";
				
		});
		
		scope.join();//One task execution
		scope.throwIfFailed();//Task Completion
		
	}
System.out.println("Tasks completed");
	
	
}
}


