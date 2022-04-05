package boasentregas.delivery.controllers;

import boasentregas.delivery.models.Destination;
import boasentregas.delivery.models.Calculates;
import boasentregas.delivery.services.CalculateService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("delivery/v1")
public class SimulationController {

    private final CalculateService calculateService;


    @GetMapping("/calculate/{id}")
    public ResponseEntity<Calculates> get(@PathVariable String id)
    {
        Calculates calculates = calculateService.FindByID(id);
        return new ResponseEntity<>(calculates, HttpStatus.OK);
    }

    @PostMapping("/calculates")
    public ResponseEntity<Calculates> calculate(@RequestBody Destination destination)
    {
        Calculates calculates = calculateService.Calculate(destination);
        return new ResponseEntity<>(calculates, HttpStatus.CREATED);
    }
}
