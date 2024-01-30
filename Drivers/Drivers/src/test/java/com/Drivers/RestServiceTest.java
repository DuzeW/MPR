//package com.Drivers;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class RestServiceTest {
//    private MyRestService service;
//    private AutoCloseable openMocks;
//    @Mock
//    private DriverRepository driverRepository;
//
//    @BeforeEach
//    public void init() {
//        openMocks = MockitoAnnotations.openMocks(this);
//        service = new MyRestService(driverRepository);
//    }
//
//    @AfterEach
//    public void tearDown() throws Exception {
//        openMocks.close();
//    }
//
//    @Test
//    public void testGetAllDrivers() {
//        List<DriverDTO> drivers = new ArrayList<>();
//        drivers.add(new DriverDTO("Capibara", LocalDate.parse("2019-09-09"), "CapibraTeam", "CapibaraWorldChampion"));
//        drivers.add(new DriverDTO("Capibara2", LocalDate.parse("2018-01-12"), "CapibraTeam2", "CapibaraWorldChampion"));
//        Mockito.when(driverRepository.findAll()).thenReturn(drivers);
//        List<DriverDTO> result = service.getAllDrivers();
//        assertEquals(drivers, result);
//    }
//    @Test
//    public void testGetDriverByName() {
//        DriverDTO driver = new DriverDTO("Capibara", LocalDate.parse("2019-09-09"), "CapibraTeam", "CapibaraWorldChampion");
//        Mockito.when(driverRepository.findByName("Capibara")).thenReturn(driver);
//        DriverDTO result = service.getDriverByName("Capibara");
//        assertEquals(driver, result);
//    }
//    @Test
//    public void testGetDriverById(){
//        MyRestService service = new MyRestService(driverRepository);
//        DriverDTO driver = new DriverDTO("Capibara", LocalDate.parse("2019-09-09"), "CapibraTeam", "CapibaraWorldChampion");
//        Mockito.when(driverRepository.findById(1L)).thenReturn(Optional.of(driver));
//        Optional<DriverDTO> result = Optional.ofNullable(service.getDriverById(1L));
//        assertEquals(Optional.of(driver), result);
//    }
//    @Test
//    public void testAddDriver() {
//        DriverDTO driver = new DriverDTO("Capibara", LocalDate.parse("2019-09-09"), "CapibraTeam", "CapibaraWorldChampion");
//        Mockito.when(driverRepository.save(driver)).thenReturn(driver);
//        DriverDTO result = service.addDriver(driver);
//        assertEquals(driver, result);
//    }
//
//
//    @Test
//    public void testUpdateDriver(){
//        MyRestService service = new MyRestService(driverRepository);
//        String initialName = "Capibara";
//        LocalDate initialDate = LocalDate.parse("2019-09-09");
//        String initialTeam = "CapibraTeam";
//        String initialRacingSeries = "CapibaraWorldChampion";
//        String expectedName = "Capibara2";
//        LocalDate expectedDate = LocalDate.parse("2018-01-12");
//        String expectedTeam = "CapibraTeam2";
//        String expectedRacingSeries = "CapibaraWorldChampion2";
//
//        DriverDTO driver = new DriverDTO(initialName, initialDate, initialTeam, initialRacingSeries);
//        DriverDTO savedDriver = service.addDriver(driver);
//        Long id = savedDriver.getId();
//
//        service.updateDriver(id, expectedName, expectedDate, expectedTeam,expectedRacingSeries);
//
//        DriverDTO updatedDriver = driverRepository.findById(id).orElseThrow();
//
//        assertEquals(expectedName, updatedDriver.getName());
//        assertEquals(expectedDate, updatedDriver.getDateOfBirth());
//        assertEquals(expectedTeam, updatedDriver.getTeam());
//        assertEquals(expectedRacingSeries, updatedDriver.getRacingSeries());
//    }
//    @Test
//    public void testDeleteDriver() {
//        MyRestService service = new MyRestService(driverRepository);
//        DriverDTO driver = new DriverDTO("Capibara", LocalDate.parse("2019-09-09"), "CapibraTeam", "CapibaraWorldChampion");
//        service.addDriver(driver);
//        Long id = driver.getId();
//        service.deleteDriver(id);
//        Optional<DriverDTO> result = Optional.ofNullable(service.getDriverById(id));
//        assertEquals(Optional.empty(), result);
//    }
//
//}
