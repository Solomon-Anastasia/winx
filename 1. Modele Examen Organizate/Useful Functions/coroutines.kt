import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking;


fun main(args: Array<String>) = runBlocking<Unit> {
    ...
    for(item in items) {
        launch {
	    // Launch Coroutines here
            ...
	}
    }
}