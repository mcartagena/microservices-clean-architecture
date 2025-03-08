package com.food.ordering.system.order.service.domain.outbox.scheduler.approval;

import com.food.ordering.system.order.service.domain.outbox.model.approval.OrderApprovalOutboxMessage;
import com.food.ordering.system.order.service.domain.exception.OrderDomainException;
import com.food.ordering.system.outbox.OutboxStatus;
import com.food.ordering.system.saga.SagaStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import com.food.ordering.system.order.service.domain.ports.output.repository.ApprovalOutboxRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.food.ordering.system.saga.order.SagaConstants.ORDER_SAGA_NAME;

@Slf4j
@Component
public class ApprovalOutboxHelper {
    private final ApprovalOutboxRepository approvalOutboxRepository;

    public ApprovalOutboxHelper(ApprovalOutboxRepository approvalOutboxRepository) {
        this.approvalOutboxRepository = approvalOutboxRepository;
    }

    @Transactional(readOnly = true)
    public Optional<List<OrderApprovalOutboxMessage>>
    getApprovalOutboxMessageByOutboxStatusAndSagaStatus(
            OutboxStatus outboxStatus, SagaStatus... sagaStatus) {
        return approvalOutboxRepository.findByTypeAndOutboxStatusAndSagaStatus(ORDER_SAGA_NAME,
                outboxStatus,
                sagaStatus);
    }

    @Transactional(readOnly = true)
    public Optional<OrderApprovalOutboxMessage>
    getApprovalOutboxMessageBySagaIdAndSagaStatus(UUID sagaId, SagaStatus... sagaStatus) {
        return approvalOutboxRepository.findByTypeAndSagaIdAndSagaStatus(ORDER_SAGA_NAME, sagaId, sagaStatus);
    }

    @Transactional
    public void save(OrderApprovalOutboxMessage orderApprovalOutboxMessage) {
        OrderApprovalOutboxMessage response = approvalOutboxRepository.save(orderApprovalOutboxMessage);
        if (response == null) {
            log.error("Could not save OrderApprovalOutboxMessage with outbox id: {}",
                    orderApprovalOutboxMessage.getId());
            throw new OrderDomainException("Could not save OrderApprovalOutboxMessage with outbox id: " +
                    orderApprovalOutboxMessage.getId());
        }
        log.info("OrderApprovalOutboxMessage saved with outbox id: {}", orderApprovalOutboxMessage.getId());
    }

    @Transactional
    public void deleteApprovalOutboxMessageByOutboxStatusAndSagaStatus(OutboxStatus outboxStatus,
                                                                       SagaStatus... sagaStatus) {
        approvalOutboxRepository.deleteByTypeAndOutboxStatusAndSagaStatus(ORDER_SAGA_NAME, outboxStatus, sagaStatus);
    }
}
