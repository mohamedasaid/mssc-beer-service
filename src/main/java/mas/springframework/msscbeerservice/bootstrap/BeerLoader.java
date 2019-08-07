package mas.springframework.msscbeerservice.bootstrap;

import mas.springframework.msscbeerservice.domain.Beer;
import mas.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class BeerLoader implements CommandLineRunner {

    private BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerOject();

    }

    private void loadBeerOject() {
        if(beerRepository.count() == 0){
            beerRepository.save(Beer.builder()
            .beerName("Mango Bobs")
            .beerStyle("IPA")
                    .quantityToBrew(300)
                    .minOnHand(12)
                    .upc(34343430001L)
                    .price(new BigDecimal(12.99))
                    .build()
            );

            beerRepository.save(Beer.builder()
                    .beerName("Galxy Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(34343343430001L)
                    .price(new BigDecimal(13.99))
                    .build()
            );
        }
        System.out.println("Loader Beers: "  + beerRepository.count());
    }
}
