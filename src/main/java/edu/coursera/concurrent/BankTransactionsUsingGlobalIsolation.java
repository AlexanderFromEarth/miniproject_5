package edu.coursera.concurrent;

import static edu.rice.pcdp.PCDP.isolated;

/**
 * A thread-safe transaction implementation using global isolation.
 */
public final class BankTransactionsUsingGlobalIsolation
        extends ThreadSafeBankTransaction {
    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void issueTransfer(final int amount, final Account src,
            final Account dst) {
        src.performTransfer(amount, dst);
    }
}
