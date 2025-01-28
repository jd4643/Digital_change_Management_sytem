package com.cms.cmstransactionservice.service;

import com.cms.cmstransactionservice.DTO.TransactionDto;
import com.cms.cmstransactionservice.config.UserServiceClient;
import com.cms.cmstransactionservice.config.VendorServiceClient;
import com.cms.cmstransactionservice.model.Transaction;
import com.cms.cmstransactionservice.model.UserPointUpdateMessage;
import com.cms.cmstransactionservice.model.VendorPointUpdateMessage;
import com.cms.cmstransactionservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.UUID;
@Service
public class TransactionService {
   /* @Autowired
    private SqsMessagingService sqsMessagingService;*/
 /*   @Autowired
    private SnsMessagingService snsMessagingService;*/

    /*@Value("${aws.sns.userPointUpdatesTopicArn}")
    private String userPointUpdatesTopicArn;

    @Value("${aws.sns.vendorPointUpdatesTopicArn}")
    private String vendorPointUpdatesTopicArn;*/

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    private UserServiceClient userServiceClient;

    @Autowired
    private VendorServiceClient vendorServiceClient;

    /**
     * Process the transaction.
     *
     * @param transactionDto The transaction details.
     * @return A success message if the transaction is processed successfully.
     */
    public String processTransaction(TransactionDto transactionDto) {
        // Validate user account
        boolean isUserValid = validateUserAccount(transactionDto.accountNumber());
        if (!isUserValid) {
            throw new RuntimeException("Invalid user account: " + transactionDto.accountNumber());
        }

        // Validate vendor ID
        boolean isVendorValid = validateVendor(transactionDto.vendorId());
        if (!isVendorValid) {
            throw new RuntimeException("Invalid vendor ID: " + transactionDto.vendorId());
        }
        // Proceed with transaction processing logic
        double change = transactionDto.cashGiven() - transactionDto.totalAmount();
        double coinChange = Math.round((change - Math.floor(change)) * 100.0) / 100.0;

        if (coinChange >= 0) {

            // Publish messages to SNS topics
           /* try {
                String userMessage = String.format("User %s earned %.2f points", transactionDto.accountNumber(), coinChange);
                snsMessagingService.publishUserPointUpdate(userMessage);

                String vendorMessage = String.format("Vendor %s credited %.2f points", transactionDto.vendorId(), coinChange);
                snsMessagingService.publishVendorPointUpdate(vendorMessage);
            } catch (Exception e) {
                throw new RuntimeException("Failed to publish messages to SNS: " + e.getMessage(), e);
            }*/

            // Publish user points update
         /*   kafkaTemplate.send("user-point-updates", new UserPointUpdateMessage(transactionDto.accountNumber(), coinChange));
            // Publish vendor points update
            kafkaTemplate.send("vendor-point-updates", new VendorPointUpdateMessage(transactionDto.vendorId(), coinChange));
            // Save transaction in the database (optional)*/
            // Save transaction in the database*/
            Transaction transaction = new Transaction();
            transaction.setAccountNumber(transactionDto.accountNumber());
            transaction.setVendorId(transactionDto.vendorId());
            transaction.setCashGiven(transactionDto.cashGiven());
            transaction.setTotalAmount(transactionDto.totalAmount());
            transaction.setChangeAmount(coinChange);
            /*transaction.setTransactionTimestamp(LocalDateTime.now());*/

            transactionRepository.save(transaction);


            return "Transaction processed successfully.";
        } else {
            throw new RuntimeException("Insufficient cash provided.");
        }
    }




    /**
     * Validate the user account by making a REST call to the User Service.
     *
     * @param accountNumber The account number to validate.
     * @return True if the account is valid, false otherwise.
     */
    private boolean validateUserAccount(String accountNumber) {
        return userServiceClient.validateAccount(accountNumber);
    }

    /**
     * Validate the vendor ID by making a REST call to the Vendor Service.
     *
     * @param vendorId The vendor ID to validate.
     * @return True if the vendor ID is valid, false otherwise.
     */
    private boolean validateVendor(String vendorId) {
        return vendorServiceClient.validateVendor(vendorId);
    }

}








