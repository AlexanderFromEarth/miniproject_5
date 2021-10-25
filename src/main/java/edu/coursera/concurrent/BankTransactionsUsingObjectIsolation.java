package edu.coursera.concurrent;

import static edu.rice.pcdp.PCDP.isolated;

/**
 * A thread-safe transaction implementation using object-based isolation.
 */
public final class BankTransactionsUsingObjectIsolation
        extends ThreadSafeBankTransaction {
    /**
     * {@inheritDoc}
     */
    @Override
    public void issueTransfer(final int amount, final Account src, final Account dst) {
        final int srcId = src.hashCode();
        final int dstId = dst.hashCode();

        final Object firstLock = srcId < dstId ? src : dst;
        final Object secondLock = srcId < dstId ? dst : src;

        synchronized (firstLock) {
            synchronized (secondLock) {
                src.performTransfer(amount, dst);
            }
        }
    }
}
