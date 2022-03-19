package boasentregas.delivery.services.impl;

import boasentregas.delivery.models.*;
import boasentregas.delivery.repositories.CalculateRepository;
import boasentregas.delivery.services.CalculateService;
import boasentregas.delivery.services.CustomerService;
import boasentregas.delivery.services.DistanceService;
import boasentregas.delivery.services.FindDistributionCenter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CalculateServiceImpl implements CalculateService
{
    private int position=0;

    private final CalculateRepository calculateRepository;

    private final FindDistributionCenter findDistributionCenter;

    private final DistanceService distanceService;

    private final CustomerService customerService;

    public Calculates FindByID(String id)
    {
        return calculateRepository.findById(id).get();
    }


    public Calculates Calculate(Destination destination)
    {

        Customer customer = customerService.FindCustomer();

        List<Ways> waysList = new ArrayList<>();

        //origem a até cd mais próximo
        DistributionCenter sourcecd = findDistributionCenter.find(destination.getAddresses().getOrigin().getZipcode());
        Distance distance = this.distance(destination.getAddresses().getOrigin(),sourcecd.getAddress());

        Ways way = this.addWays(destination.getAddresses().getOrigin(),sourcecd.getAddress(),distance);
        waysList.add(way);
        //---------------------------
        //cd mais próximo do endereço de destino
        DistributionCenter destinationcd = findDistributionCenter.find(destination.getAddresses().getDestination().getZipcode());
        //____________________________


        if (sourcecd.getAddress().getName().equals(destinationcd.getAddress().getName()))
        {
            Calculate calculate = Value(0.0,0.0,0.0);
            Calculates calculates = new Calculates();
            calculates.setCalculate(calculate);
            calculates.setWaysList(waysList);

            return calculates;
        }
        DistributionCenter sourceMain;
        if (!sourcecd.getMain())
        {
            sourceMain = findDistributionCenter.findName(sourcecd.getNameMain());
            distance = new Distance();
            distance.setDistance(sourcecd.getDistanceMain());
            distance.setDuration(sourcecd.getTime());

            way = this.addWays(sourcecd.getAddress(),sourceMain.getAddress(),distance);
            waysList.add(way);
        }
        else
        {
            sourceMain = sourcecd;
        }


        if (!destinationcd.getMain())
        {
            DistributionCenter destinationMain = findDistributionCenter.findName(destinationcd.getNameMain());

            if (!sourceMain.getName().equals(destinationMain.getName()))
            {
                distance = this.distance(sourceMain.getAddress(),destinationMain.getAddress());

                way = this.addWays(sourceMain.getAddress(),destinationMain.getAddress(),distance);
                waysList.add(way);
            }

            distance = new Distance();
            distance.setDistance(destinationcd.getDistanceMain());
            distance.setDuration(destinationcd.getTime());
            way = this.addWays(destinationMain.getAddress(),destinationcd.getAddress(),distance);
            waysList.add(way);
        }

        //cd mais próximo do destino até o destino
        distance = this.distance(destinationcd.getAddress(),destination.getAddresses().getDestination());

        way = this.addWays(destinationcd.getAddress(),destination.getAddresses().getDestination(),distance);
        waysList.add(way);

        Calculate calculate = Value(0.0,0.0,0.0);

        Calculates calculates = new Calculates();
        calculates.setCalculate(calculate);
        calculates.setWaysList(waysList);
        calculates.setCustomer(customer);

        calculateRepository.save(calculates);

        return calculates;
    }

    private Ways addWays(Address origin, Address destination, Distance distance)
    {
        position++;
        Addresses addresses = new Addresses();
        addresses.setOrigin(origin);
        addresses.setDestination(destination);
        return new Ways(position, addresses,distance);
    }

    private Distance distance(Address origin, Address destination)
    {
        Addresses addresses = new Addresses(origin, destination);
        return distanceService.Distance(addresses);
    }

    private Calculate Value(double distance,double weight,double size)
    {
        LocalDate date = LocalDate.of(2022,3,27);
        return new Calculate(10.0,date,21);
    }
}
