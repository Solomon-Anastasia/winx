//Model Compus
interface IMedia{
    fun play()
    fun displaySubtitle()
    fun setPlaySpeed(speed:Float)
    fun getName():String
}
class Movie(val title:String):IMedia{
    private var speed=1f
    override fun play(){
        println("now playing: $title...")
    }
    override fun displaySubtitle(){
        println("Display subtitle")
    }
    override fun setPlaySpeed(speed:Float){
        this.speed=speed
        println("Current play speed set to: $speed")
    }
    override fun getName():String{
        return title
    }
}
class PlayList(val title:String):IMedia{
    var movieList:MutableList<IMedia> = mutableListOf()
    fun addNewMedia(media:IMedia) = movieList.add(media)
    fun removeMedia(media:IMedia){
        movieList = movieList.filter{it.getName()!= media.getName()}.toMutableList()
    }
    override fun play(){
        movieList.forEach{
            it.play()
        }
    }
    override fun displaySubtitle(){
        println("Display certai subtitle")
    }
    override fun setPlaySpeed(speed: Float){
        movieList.forEach{it.setPlaySpeed(speed)}
    }
    override fun getName():String{
        return title
    }
}

fun main(args: Array<String>){
    var actionMoviePlayList:PlayList = PlayList("Action Movie")
    val movieB:IMedia = Movie("The Dark Knight")
    val movieC:IMedia = Movie("Inception")
    val movieD:IMedia = Movie("The Matrix")

    actionMoviePlayList.apply{
        addNewMedia(movieB)
        addNewMedia(movieC)
        addNewMedia(movieD)
    }

    val dramaPlayList:PlayList = PlayList("Drama Play List")
    val movie1:IMedia = Movie("The Godfather")
    val movie2:IMedia = Movie("The Shawshank Redemption")

    dramaPlayList.apply{
        addNewMedia(movie1)
        addNewMedia(movie2)
    }

    val myPlayList:PlayList = PlayList("My Play List")
    myPlayList.apply{
        addNewMedia(actionMoviePlayList)
        addNewMedia(dramaPlayList)
    }
    myPlayList.play()
}