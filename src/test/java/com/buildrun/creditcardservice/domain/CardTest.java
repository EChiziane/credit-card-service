package com.buildrun.creditcardservice.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class CardTest {

    @Mock
    private Customer customer;

    @InjectMocks
    private Card card;

    @Nested
    class BasicCreditCardAvailabilityTests {

        @Test
        void shouldBeAvailableWhenIncomeIsBelow2kAndScoreIsAbove500() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(2000.0);
            doReturn(true).when(customer).isScoreGreaterThan(500.0);

            assertTrue(card.isBasicCreditCardAvailable());
        }

        @Test
        void shouldNotBeAvailableWhenIncomeIsAbove2k() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(2000.0);
            doReturn(true).when(customer).isScoreGreaterThan(500.0);

            assertFalse(card.isBasicCreditCardAvailable());
        }

        @Test
        void shouldNotBeAvailableWhenScoreIs500OrLower() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(2000.0);
            doReturn(false).when(customer).isScoreGreaterThan(500.0);

            assertFalse(card.isBasicCreditCardAvailable());
        }
    }

    @Nested
    class GoldCreditCardAvailabilityTests {

        @Test
        void shouldBeAvailableWhenIncomeIsBetween2kAnd5kAndScoreIsAbove600() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(5000.0);
            doReturn(true).when(customer).isScoreGreaterThan(600.0);
            doReturn(true).when(customer).isIncomeEqualOrGreaterThan(2000.0);

            assertTrue(card.isGoldCreditCardAvailable());
        }

        @Test
        void shouldNotBeAvailableWhenIncomeIsBelow2k() {
            doReturn(false).when(customer).isIncomeEqualOrGreaterThan(2000.0);
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(5000.0);
            doReturn(true).when(customer).isScoreGreaterThan(600.0);

            assertFalse(card.isGoldCreditCardAvailable());
        }

        @Test
        void shouldNotBeAvailableWhenIncomeIsAbove5k() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(5000.0);
            doReturn(true).when(customer).isIncomeEqualOrGreaterThan(2000.0);
            doReturn(true).when(customer).isScoreGreaterThan(600.0);

            assertFalse(card.isGoldCreditCardAvailable());
        }

        @Test
        void shouldNotBeAvailableWhenScoreIs600OrLower() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(5000.0);
            doReturn(true).when(customer).isIncomeEqualOrGreaterThan(2000.0);
            doReturn(false).when(customer).isScoreGreaterThan(600.0);

            assertFalse(card.isGoldCreditCardAvailable());
        }
    }

    @Nested
    class PlatinumCreditCardAvailabilityTests {

        @Test
        void shouldBeAvailableWhenIncomeIsAbove5kAndScoreIsAbove750() {
            doReturn(true).when(customer).isScoreGreaterThan(750.0);
            doReturn(true).when(customer).isIncomeEqualOrGreaterThan(5000.0);

            assertTrue(card.isPlatinumCreditCardAvailable());
        }

        @Test
        void shouldNotBeAvailableWhenIncomeIsBelow5k() {
            doReturn(true).when(customer).isScoreGreaterThan(750.0);
            doReturn(false).when(customer).isIncomeEqualOrGreaterThan(5000.0);

            assertFalse(card.isPlatinumCreditCardAvailable());
        }

        @Test
        void shouldNotBeAvailableWhenScoreIs750OrLower() {
            doReturn(true).when(customer).isIncomeEqualOrGreaterThan(5000.0);
            doReturn(false).when(customer).isScoreGreaterThan(750.0);

            assertFalse(card.isPlatinumCreditCardAvailable());
        }
    }
}
