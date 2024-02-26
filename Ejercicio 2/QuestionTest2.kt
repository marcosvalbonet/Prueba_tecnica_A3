class QuestionTest2 {

    fun getMoviesInPlatforms(movies:List<Movie>, platforms:List<Platform>):List<MovieInPlatform>{
        val movieIdsInService = platforms.map { platform -> platform.movieId }

        return movies.filter { movie ->
            movie.id in movieIdsInService
        }.map { movie ->
            MovieInPlatform(movie, platforms.find { platform -> platform.movieId == movie.id })
        }
    }


    @Test
    fun `get movies in platforms result the movie that appears in platforms`(){

        val movie1 = Movie("1", "Dumbo")
        val movie2 = Movie("2", "Pinocho")

        val movies = listOf(movie1, movie2)
        val platforms = listOf(Platform("2", true, true))

        val moviesInPlatform = question2Test.getMoviesInPlatforms(movies, platforms)

        assert (movies.contains(moviesInPlatform.first().movie))
        assert (platforms.first().movieId == moviesInPlatform.first().movie.movieId)

    }

    @Test
    fun `get movies in platforms not return the movie that not appear in platforms`(){
        val movie1 = Movie("1", "Dumbo")
        val movie2 = Movie("2", "Pinocho")

        val movies = listOf(movie1, movie2)
        val platforms = listOf(Platform("2", true, true))

        val moviesInPlatform = question2Test.getMoviesInPlatforms(movies, platforms)

        assert (moviesInPlatform.first().movie.movieId != movie1.movieId)
        assert (platforms.first().movieId != moviesInPlatform.first().movie.movieId)

    }

    @Test
    fun `get movies in platforms return empty list when all movies don't have platform`(){
        val movie1 = Movie("1", "Dumbo")
        val movie2 = Movie("2", "Pinocho")

        val movies = listOf(movie1, movie2)
        val platforms = listOf(Platform("3", true, true))

        val moviesInPlatform = question2Test.getMoviesInPlatforms(movies, platforms)

        assertTrue (moviesInPlatform.isEmpty())

    }

}