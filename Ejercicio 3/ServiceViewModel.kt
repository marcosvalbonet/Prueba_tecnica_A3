class ServiceViewModel(private val userProcessor: UserProcessor, private val serviceApi:ServiceApi): ViewModel() {

    private var _isLoaded = MutableLiveData<String>()
    val isLoaded: LiveData<String>
        get() = _isLoaded

    fun processAndLogin(name:String, cardId:Int){
	
		//use the userProcess to process the name and cardId from the user and obtain the completed object.
        val userLoginData = userProcessor.processUser(name, cardId)
		
		//call the serviceApi sending the data
        viewModelScope.launch {
            val result = serviceApi.sendUser(userLoginData)
            //update the ui writing the livedata
            if (result) _isLoaded.postValue("User logged")
            else _isLoaded.postValue("User not logged")
        }

    }

}