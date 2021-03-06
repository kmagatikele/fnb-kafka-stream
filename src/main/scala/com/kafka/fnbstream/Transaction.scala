package com.kafka.fnbstream

case class Transaction(
                        transactionTraceIdentifier:String,
                        accountNumber:String,
                        transactionTypeIdentifier:String,
                        numberOfTransactions:Long,
                        transactionEffectiveDate:String,
                        transactionAmount:Double,
                        accountHoldingCompanyCode: Long,
                        accountCurrencyCode:String,
                        transactionOriginalCurrency:String,
                        transactionTypeCode:String,
                        transactionReversalIndicator:String,
                        transactionChannel:String,
                        transactionSourceBranchCode:String,
                        transactionSourceSystem:String,
                        eventDateTime:String,
                        productCode:String,
                        subProductCode:String,
                        ledgerBalanceAfterTransaction:Double,
                        collectedBalanceAfterTransaction:Double,
                        transactionSignage:String,
                        transactionGLCategory:String,
                        transactionTypeIndicator:String,
                        remoteBranchClearingCode:String,
                        officerCode:String,
                        transactionDescription:String,
                        transactionSequenceNumberStatement:String,
                        numberOfForeignDepositedItems:String,
                        cashAmount:Double,
                        interestCollected:Double,
                        toAccountNumber:String,
                        fromAccountNumber:String,
                        transactionDescriptionContinued:String,
                        originalTransactionAmount:Double,
                        exchangeRate:Double,
                        acrruedTransactionFee:Double
                      )

