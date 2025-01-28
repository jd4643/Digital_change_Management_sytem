/*
package com.cms.cmsuserservice.kafka;

import com.cms.cmsuserservice.model.BalanceUpdateMessage;
import com.cms.cmsuserservice.model.User;
import com.cms.cmsuserservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserBalanceConsumer {

    @Autowired
    private UserRepository userRepository;

    @KafkaListener(topics = "user-balance-updates", groupId = "user-service-group")
    public void updateUserBalance(BalanceUpdateMessage message) {
        Optional<User> userOpt = userRepository.findByAccountNumber(message.accountNumber());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setPointsBalance(user.pointsBalance()+ message.change()
            );
            userRepository.save(user);
        }
    }
}
*/
