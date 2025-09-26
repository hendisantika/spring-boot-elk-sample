package id.my.hendisantika.elksample.config;

import id.my.hendisantika.elksample.entity.Customer;
import id.my.hendisantika.elksample.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-elk-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 26/09/25
 * Time: 09.50
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final CustomerRepository customerRepository;

    @Override
    public void run(ApplicationArguments args) {
        if (customerRepository.count() == 0) {
            log.info("Initializing default customer data...");
            initializeCustomerData();
            log.info("Successfully initialized {} customer records", customerRepository.count());
        } else {
            log.info("Customer data already exists. Skipping initialization.");
        }
    }

    private void initializeCustomerData() {
        // Create 100 anime character customer records (20 per series)

        // NARUTO Characters (20)
        createNarutoCharacters();

        // JUJUTSU KAISEN Characters (20)
        createJujutsuKaisenCharacters();

        // ATTACK ON TITAN Characters (20)
        createAttackOnTitanCharacters();

        // DEMON SLAYER Characters (20)
        createDemonSlayerCharacters();

        // ONE PIECE Characters (20)
        createOnePieceCharacters();

        log.info("Successfully added 100 anime character customer records!");
    }

    private void createNarutoCharacters() {
        String[] names = {
                "Naruto Uzumaki", "Sasuke Uchiha", "Sakura Haruno", "Kakashi Hatake", "Hinata Hyuga",
                "Shikamaru Nara", "Ino Yamanaka", "Choji Akimichi", "Rock Lee", "Neji Hyuga",
                "Tenten", "Might Guy", "Itachi Uchiha", "Gaara", "Temari",
                "Kankuro", "Jiraiya", "Tsunade", "Orochimaru", "Minato Namikaze"
        };

        for (int i = 0; i < names.length; i++) {
            Customer customer = Customer.builder()
                    .name(names[i])
                    .email(names[i].toLowerCase().replace(" ", ".") + "@konoha.village")
                    .phone("+81-3-" + String.format("1%03d-%04d", i + 1, 1000 + i))
                    .address((i + 1) + " Hidden Leaf Street")
                    .city("Konohagakure")
                    .state("Fire Country")
                    .country("Japan")
                    .build();
            customerRepository.save(customer);
            log.info("Added Naruto character: {}", customer.getName());
        }
    }

    private void createJujutsuKaisenCharacters() {
        String[] names = {
                "Yuji Itadori", "Megumi Fushiguro", "Nobara Kugisaki", "Satoru Gojo", "Suguru Geto",
                "Maki Zenin", "Toge Inumaki", "Panda", "Yuta Okkotsu", "Kento Nanami",
                "Mei Mei", "Aoi Todo", "Mai Zenin", "Noritoshi Kamo", "Kokichi Muta",
                "Ryomen Sukuna", "Mahito", "Jogo", "Hanami", "Dagon"
        };

        for (int i = 0; i < names.length; i++) {
            Customer customer = Customer.builder()
                    .name(names[i])
                    .email(names[i].toLowerCase().replace(" ", ".") + "@jujutsu.tech")
                    .phone("+81-3-" + String.format("2%03d-%04d", i + 1, 2000 + i))
                    .address((i + 1) + " Tokyo Jujutsu High")
                    .city("Tokyo")
                    .state("Tokyo")
                    .country("Japan")
                    .build();
            customerRepository.save(customer);
            log.info("Added Jujutsu Kaisen character: {}", customer.getName());
        }
    }

    private void createAttackOnTitanCharacters() {
        String[] names = {
                "Eren Yeager", "Mikasa Ackerman", "Armin Arlert", "Levi Ackerman", "Erwin Smith",
                "Hange Zoe", "Jean Kirstein", "Connie Springer", "Sasha Blouse", "Historia Reiss",
                "Ymir", "Reiner Braun", "Bertolt Hoover", "Annie Leonhart", "Marco Bott",
                "Christa Lenz", "Zeke Yeager", "Porco Galliard", "Pieck Finger", "Falco Grice"
        };

        for (int i = 0; i < names.length; i++) {
            Customer customer = Customer.builder()
                    .name(names[i])
                    .email(names[i].toLowerCase().replace(" ", ".") + "@paradis.island")
                    .phone("+49-30-" + String.format("3%03d-%04d", i + 1, 3000 + i))
                    .address((i + 1) + " Wall Maria District")
                    .city("Shiganshina")
                    .state("Paradis")
                    .country("Germany")
                    .build();
            customerRepository.save(customer);
            log.info("Added Attack on Titan character: {}", customer.getName());
        }
    }

    private void createDemonSlayerCharacters() {
        String[] names = {
                "Tanjiro Kamado", "Nezuko Kamado", "Zenitsu Agatsuma", "Inosuke Hashibira", "Giyu Tomioka",
                "Shinobu Kocho", "Kyojuro Rengoku", "Tengen Uzui", "Mitsuri Kanroji", "Muichiro Tokito",
                "Gyomei Himejima", "Sanemi Shinazugawa", "Obanai Iguro", "Kanao Tsuyuri", "Genya Shinazugawa",
                "Muzan Kibutsuji", "Akaza", "Doma", "Kokushibo", "Tamayo"
        };

        for (int i = 0; i < names.length; i++) {
            Customer customer = Customer.builder()
                    .name(names[i])
                    .email(names[i].toLowerCase().replace(" ", ".") + "@demonslayer.corps")
                    .phone("+81-3-" + String.format("4%03d-%04d", i + 1, 4000 + i))
                    .address((i + 1) + " Mount Fujikasane")
                    .city("Taisho Era")
                    .state("Japan")
                    .country("Japan")
                    .build();
            customerRepository.save(customer);
            log.info("Added Demon Slayer character: {}", customer.getName());
        }
    }

    private void createOnePieceCharacters() {
        String[] names = {
                "Monkey D. Luffy", "Roronoa Zoro", "Nami", "Usopp", "Sanji",
                "Tony Tony Chopper", "Nico Robin", "Franky", "Brook", "Jinbe",
                "Portgas D. Ace", "Sabo", "Trafalgar Law", "Eustass Kid", "Killer",
                "Shanks", "Marshall D. Teach", "Whitebeard", "Kaido", "Big Mom"
        };

        for (int i = 0; i < names.length; i++) {
            Customer customer = Customer.builder()
                    .name(names[i])
                    .email(names[i].toLowerCase().replace(" ", ".").replace(".", "") + "@grandline.pirates")
                    .phone("+1-555-" + String.format("5%03d-%04d", i + 1, 5000 + i))
                    .address((i + 1) + " Thousand Sunny")
                    .city("Grand Line")
                    .state("New World")
                    .country("Pirate World")
                    .build();
            customerRepository.save(customer);
            log.info("Added One Piece character: {}", customer.getName());
        }
    }
}