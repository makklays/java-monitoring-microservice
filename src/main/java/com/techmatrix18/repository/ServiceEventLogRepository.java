package com.techmatrix18.repository;

import com.techmatrix18.model.ServiceEventLog;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * Repository for managing ServiceEventLog entities.
 *
 * save(S entity)	                            Mono<T>	Сохраняет объект (insert или update)
 * saveAll(Iterable<S> entities)	            Flux<S>	Сохраняет несколько объектов
 * saveAll(Publisher<S> entityStream)	        Flux<S>	Сохраняет поток объектов (reactive)
 * findById(ID id)	                            Mono<T>	Найти объект по id
 * existsById(ID id)	                        Mono<Boolean>	Проверить, существует ли объект по id
 * findAll()	                                Flux<T>	Найти все объекты
 * findAllById(Iterable<ID> ids)	            Flux<T>	Найти объекты по списку id
 * findAll(Sort sort)	                        Flux<T>	Найти все объекты с сортировкой
 * count()	                                    Mono<Long>	Количество объектов в репозитории
 * deleteById(ID id)	                        Mono<Void>	Удалить объект по id
 * delete(T entity)	                            Mono<Void>	Удалить объект
 * deleteAll(Iterable<? extends T> entities)	Mono<Void>	Удалить список объектов
 * deleteAll()	                                Mono<Void>	Удалить все объекты
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 07.01.2026
 */
@Repository
public interface ServiceEventLogRepository extends ReactiveCrudRepository<ServiceEventLog, Long> {

    // Найти все события по конкретному сервису
    Flux<ServiceEventLog> findAllByServiceName(String serviceName);

    // Найти все события по типу события (PAYMENT_CREATED, CARD_BLOCKED и т.д.)
    Flux<ServiceEventLog> findAllByEventType(String eventType);

    // Найти все события по типу сущности (Payment, CreditCard и т.д.)
    Flux<ServiceEventLog> findAllByEntityType(String entityType);

    // Найти все события по ID сущности
    Flux<ServiceEventLog> findAllByEntityId(Long entityId);

    // Найти все события в диапазоне времени (epoch milliseconds)
    Flux<ServiceEventLog> findAllByEventTimeBetween(Long startEpochMillis, Long endEpochMillis);

    // Комбинированный поиск: сервис + тип события
    Flux<ServiceEventLog> findAllByServiceNameAndEventType(String serviceName, String eventType);

    // Комбинированный поиск: сервис + тип события + диапазон времени
    Flux<ServiceEventLog> findAllByServiceNameAndEventTypeAndEventTimeBetween(
        String serviceName,
        String eventType,
        Long startEpochMillis,
        Long endEpochMillis
    );
}

