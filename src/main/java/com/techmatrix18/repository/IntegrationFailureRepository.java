package com.techmatrix18.repository;

import com.techmatrix18.model.IntegrationFailure;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

/**
 * Repository for managing IntegrationFailure entities.
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
public interface IntegrationFailureRepository extends ReactiveCrudRepository<IntegrationFailure, Long> {

    // Найти все ошибки по сервису-источнику
    Flux<IntegrationFailure> findAllBySourceService(String sourceService);

    // Найти все ошибки по сервису-получателю
    Flux<IntegrationFailure> findAllByTargetService(String targetService);

    // Найти ошибки по операции (CREATE, UPDATE, DELETE и т.д.)
    Flux<IntegrationFailure> findAllByOperation(String operation);

    // Найти ошибки по коду ошибки
    Flux<IntegrationFailure> findAllByErrorCode(String errorCode);

    // Найти ошибки, произошедшие в диапазоне времени
    Flux<IntegrationFailure> findAllByOccurredAtBetween(LocalDateTime start, LocalDateTime end);

    // Найти все нерешённые ошибки
    Flux<IntegrationFailure> findAllByResolvedFalse();

    // Комбинированный поиск: сервис-источник + сервис-получатель + операция + статус решения
    Flux<IntegrationFailure> findAllBySourceServiceAndTargetServiceAndOperationAndResolved(
        String sourceService,
        String targetService,
        String operation,
        Boolean resolved
    );
}

