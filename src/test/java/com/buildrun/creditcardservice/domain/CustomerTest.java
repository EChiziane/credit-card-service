package com.buildrun.creditcardservice.domain;

import com.buildrun.creditcardservice.Factory.CustomerFactory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerTest {

    @Nested
    class isIncomeEqualOrGreaterThan {

        @Test
        void shouldReturnTrueWhenIncomeIsEqual() { // Nome melhorado
            var customer = CustomerFactory.build();
            assertTrue(customer.isIncomeEqualOrGreaterThan(3000.0));
        }

        @Test
        void shouldReturnTrueWhenIncomeIsGreater() { // Nome melhorado
            var customer = CustomerFactory.build();
            assertTrue(customer.isIncomeEqualOrGreaterThan(2000.0));
        }

        @Test
        void shouldReturnFalseWhenIncomeIsLower() { // Nome melhorado
            var customer = CustomerFactory.build();
            assertFalse(customer.isIncomeEqualOrGreaterThan(4000.0));
        }
    }

    @Nested
    class isIncomeEqualOrLowerThan {

        @Test
        void shouldReturnTrueWhenIncomeIsEqual() { // Nome melhorado + correção de "costumer" -> "customer"
            var customer = CustomerFactory.build();
            assertTrue(customer.isIncomeEqualOrLowerThan(3000.0));
        }

        @Test
        void shouldReturnTrueWhenIncomeIsLower() { // Nome melhorado
            var customer = CustomerFactory.build();
            assertTrue(customer.isIncomeEqualOrLowerThan(4000.0));
        }

        @Test
        void shouldReturnFalseWhenIncomeIsGreater() { // Nome melhorado
            var customer = CustomerFactory.build();
            assertFalse(customer.isIncomeEqualOrLowerThan(1000.0));
        }
    }

    @Nested
    class isIncomeBetween {

        @Test
        void shouldReturnTrueWhenIncomeIsWithinRange() { // Nome melhorado
            var customer = CustomerFactory.build(3000.0);
            assertTrue(customer.isIncomeBetween(2000, 5000));
        }

        @Test
        void shouldReturnTrueWhenIncomeEqualsMinBoundary() { // Nome melhorado
            var customer = CustomerFactory.build(2000.0);
            assertTrue(customer.isIncomeBetween(2000, 5000));
        }

        @Test
        void shouldReturnTrueWhenIncomeEqualsMaxBoundary() { // Nome melhorado
            var customer = CustomerFactory.build(5000.0);
            assertTrue(customer.isIncomeBetween(2000, 5000));
        }

        @Test
        void shouldReturnFalseWhenIncomeIsOutOfRange() { // Nome melhorado
            var customer = CustomerFactory.build(5000.0);
            assertFalse(customer.isIncomeBetween(2000, 3000));
        }
    }

    @Nested
    class isScoreGreaterThan {

        @Test
        void shouldReturnTrueWhenScoreIsGreater() { // Nome melhorado
            var customer = CustomerFactory.build(2000);
            assertTrue(customer.isScoreGreaterThan(1000.0));
        }

        @Test
        void shouldReturnFalseWhenScoreIsLower() { // Nome melhorado
            var customer = CustomerFactory.build(1000);
            assertFalse(customer.isScoreGreaterThan(2000.0));
        }

        @Test
        void shouldReturnFalseWhenScoreIsEqual() { // Nome melhorado
            var customer = CustomerFactory.build(1000);
            assertFalse(customer.isScoreGreaterThan(1000.0));
        }
    }



}