package com.techmatrix18.repository;

import com.techmatrix18.model.FraudIndicator;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * Repository for managing FraudIndicator entities.
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
public interface FraudIndicatorRepository extends ReactiveCrudRepository<FraudIndicator, Long> {

    // Найти все индикаторы по типу сущности (USER / CARD / ACCOUNT)
    Flux<FraudIndicator> findAllByEntityType(String entityType);

    // Найти все индикаторы по ID сущности
    Flux<FraudIndicator> findAllByEntityId(Long entityId);

    // Найти все индикаторы по типу индикатора мошенничества
    Flux<FraudIndicator> findAllByIndicatorType(String indicatorType);

    // Найти все нерешённые индикаторы
    Flux<FraudIndicator> findAllByResolvedFalse();

    // Найти индикаторы по дате создания (epoch milliseconds)
    Flux<FraudIndicator> findAllByCreatedAtBetween(Long startEpochMillis, Long endEpochMillis);

    // Найти индикаторы по типу сущности и ID сущности
    Flux<FraudIndicator> findAllByEntityTypeAndEntityId(String entityType, Long entityId);

    // Найти индикаторы по типу индикатора и статусу решения
    Flux<FraudIndicator> findAllByIndicatorTypeAndResolved(String indicatorType, Boolean resolved);
}

