package by.trjava.library.servive.factory;

import by.trjava.library.servive.ClientService;
import by.trjava.library.servive.LibraryService;
import by.trjava.library.servive.impl.ClientServiceImpl;
import by.trjava.library.servive.impl.LibraryServiceImpl;

public class ServiceFactory{
    private static final ServiceFactory instance = new ServiceFactory();

    private final LibraryService libraryServiceImpl = new LibraryServiceImpl();
    private final ClientService clientServiceImpl = new ClientServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public ClientService getClentService(){
        return clientServiceImpl;
    }

    public LibraryService getLibraryService() {
        return libraryServiceImpl;
    }
}
