package by.trjava.library.service.factory;

import by.trjava.library.service.IClientService;
import by.trjava.library.service.ILibraryService;
import by.trjava.library.service.impl.ClientServiceImpl;
import by.trjava.library.service.impl.LibraryServiceImpl;

public final class ServiceFactory{
    private static final ServiceFactory instance = new ServiceFactory();

    private final ILibraryService ILibraryServiceImpl = new LibraryServiceImpl();
    private final IClientService IClientServiceImpl = new ClientServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public IClientService getClientService(){
        return IClientServiceImpl;
    }

    public ILibraryService getLibraryService() {
        return ILibraryServiceImpl;
    }
}
