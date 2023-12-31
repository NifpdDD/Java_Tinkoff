package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static edu.hw3.Contact.Sortby.ASC;
import static edu.hw3.Contact.Sortby.DESC;

class ContactTest {
    static Arguments[] contactsAsc() {
        return new Arguments[] {
            Arguments.of(
                new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"},
                new Contact[] {
                    new Contact("Thomas Aquinas"),
                    new Contact("Rene Descartes"),
                    new Contact("David Hume"),
                    new Contact("John Locke")
                }
            ),
            Arguments.of(
                new String[] {"John Doe", "Pivovoz", "Alex", "Michael Brown"},
                new Contact[] {
                    new Contact("Alex"),
                    new Contact("Michael Brown"),
                    new Contact("John Doe"),
                    new Contact("Pivovoz")
                }
            )

        };
    }

    static Arguments[] contactsDesc() {
        return new Arguments[] {
            Arguments.of(
                new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"},
                new Contact[] {
                    new Contact("Carl Gauss"),
                    new Contact("Leonhard Euler"),
                    new Contact("Paul Erdos"),
                }
            )
        };
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
    @MethodSource("contactsDesc")
    void if_correct_contacts_should_parse_desc(String[] contacts, Contact[] parseContacts) {
        var c = new Contact();

        var parse = c.parseContacts(contacts, DESC);

        Assertions.assertThat(parse).isEqualTo(parseContacts);
    }

    @ParameterizedTest
    @MethodSource("contactsAsc")
    void if_correct_contacts_should_parse_asc(String[] contacts, Contact[] parseContacts) {
        var c = new Contact();

        var parse = c.parseContacts(contacts, ASC);

        Assertions.assertThat(parse).isEqualTo(parseContacts);
    }

    @ParameterizedTest
    @MethodSource("error_contacts")
    void if_not_correct_contacts_should_retrun_empty(String[] contacts, Contact.Sortby sort, Contact[] parseContacts) {
        var c = new Contact();

        var parse = c.parseContacts(contacts, sort);

        Assertions.assertThat(parse).isEqualTo(parseContacts);
    }

}
