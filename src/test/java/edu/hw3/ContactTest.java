package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static edu.hw3.Contact.Sortby.ASC;
import static edu.hw3.Contact.Sortby.DESC;

class ContactTest {
    static Arguments[] contacts() {
        return new Arguments[] {
            Arguments.of(
                new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"},
                ASC,
                new Contact[] {
                    new Contact("Thomas Aquinas"),
                    new Contact("Rene Descartes"),
                    new Contact("David Hume"),
                    new Contact("John Locke")
                }
            ),
            Arguments.of(
                new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"},
                DESC,
                new Contact[] {
                    new Contact("Carl Gauss"),
                    new Contact("Leonhard Euler"),
                    new Contact("Paul Erdos"),
                }
            ),
            Arguments.of(
                new String[] {"John Doe", "Pivovoz", "Alex", "Michael Brown"},
                ASC,
                new Contact[] {
                    new Contact("Alex"),
                    new Contact("Michael Brown"),
                    new Contact("John Doe"),
                    new Contact("Pivovoz")
                }
            )

        };
    }
    @ParameterizedTest
    @MethodSource("contacts")
    void if_correct_contacts_should_parse(String[] contacts, Contact.Sortby sort, Contact[] parseContacts) {
        var c = new Contact();

        var parse = c.parseContacts(contacts, sort);

        Assertions.assertThat(parse).isEqualTo(parseContacts);
    }


    static Arguments[] error_contacts() {
        return new Arguments[] {
            Arguments.of(
                new String[] {},
                ASC,
                new Contact[] {}
            ),
            Arguments.of(
                null,
                ASC,
                new Contact[] {}
            )

        };
    }

    @ParameterizedTest
    @MethodSource("error_contacts")
    void if_not_correct_contacts_should_retrun_empty(String[] contacts, Contact.Sortby sort, Contact[] parseContacts) {
        var c = new Contact();

        var parse = c.parseContacts(contacts, sort);

        Assertions.assertThat(parse).isEqualTo(parseContacts);
    }

}
