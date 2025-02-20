package com.buildrun.creditcardservice.domain;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class CardTest {

    @Mock
    private Customer customer;

    @InjectMocks
    private Card card;

    @Nested
    class isBasicCreditCardAvailable {
        @Test
        void shouldBeAvailableWhenIncomeLowerThan2kAndScoreGreaterThan500() {

            doReturn(true).when(customer).isIncomeEqualOrLowerThan(2000.0);
            doReturn(true).when(customer).isScoreGreaterThan(500.0);

            assertTrue(card.isBasicCreditCardAvailable());

        }

    }

    @Nested
    class isGoldCreditCardAvailable {
        @Test
        void shouldBeAvailableWhenIncomeBetween2kAnd5kAndScoreGreaterThan600() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(5000.0);
            doReturn(true).when(customer).isScoreGreaterThan(600.0);
            doReturn(true).when(customer).isIncomeEqualOrGreaterThan(2000.0);
            assertTrue(card.isGoldCreditCardAvailable());

        }

    }

    @Nested
    class isPlatinumCreditCardAvailable {
        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrGreaterThan5kAndScoreGreaterThan() {
            doReturn(true).when(customer).isScoreGreaterThan(750.0);
            doReturn(true).when(customer).isIncomeEqualOrGreaterThan(5000.0);
            assertTrue(card.isPlatinumCreditCardAvailable());

        }

    }

}