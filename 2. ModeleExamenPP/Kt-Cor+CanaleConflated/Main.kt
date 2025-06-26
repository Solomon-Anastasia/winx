import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ClosedReceiveChannelException
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File


///Am folosit Channel normal, cu conflated nu imi afisa toate cuvintele deoarece se suprascriau
///Era nevoie de un mod de sincronizare(sa se scrie in canal doar cand este gol), am incercat cu conditii dar da eroare
///Nu prea vad sensul problemei totusi, de ce sa folosesti canale Conflated si sa te chinui dupa cu sincronizarea cand poti sa folosesti orice alt tip de canale...
suspend fun CoroutineScope.get_from_channel_then_send_to_another(ch:Channel<String>)
{
    val ch_list= listOf(Channel<String>(),Channel<String>(Channel.CONFLATED),Channel<String>(Channel.CONFLATED))
    val tasks=ch_list.map { channel -> launch { print_string(channel) } }
    var i=0
    try
    {
        while(true)
        {
            ch_list[i].send(ch.receive())
            i = (i + 1) % 3
        }
    }
    catch(e:ClosedReceiveChannelException)
    {
        ch_list.forEach { it.close() }
        tasks.forEach { it.join() }
    }
}

suspend fun print_string(ch:Channel<String>){
    try
    {
        while(true)
            println("Thread \"${Thread.currentThread()}\" -> \"${ch.receive()}\"")
    }
    catch(e:ClosedReceiveChannelException)
    {

    }
}

fun main()= runBlocking{
    val ch_list= listOf(Channel<String>(),Channel<String>(Channel.CONFLATED),Channel<String>(Channel.CONFLATED))
    val words=ArrayList<String>(File("text.txt").readText().split(' '))
    val tasks=ch_list.map { channel -> launch { get_from_channel_then_send_to_another(channel) } }
    var i=0
    while(!words.isEmpty())
    {
        ch_list[i].send(words.removeFirst())
        i = (i + 1) % 3
    }
    ch_list.forEach { it.close() }
    tasks.forEach { it.join() }
}