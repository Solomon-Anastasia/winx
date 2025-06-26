class YoutubeChannel {
    val videos = mutableListOf<String>()
    val subscribers = mutableListOf<Subscriber>()

    fun addVideo(url : String) {
        videos.add(url)
        notifySubscribersOfNewVideo()
    }

    private fun notifySubscribersOfNewVideo() {
        for (subscriber in subscribers)
            subscriber.updateVideoAdded()
    }

    fun addSubscriber(subscriber: Subscriber) {
        subscribers.add(subscriber)
        subscriber.updateSubscriberAdded()
    }
}