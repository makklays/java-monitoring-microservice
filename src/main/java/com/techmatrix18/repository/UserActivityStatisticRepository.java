package com.techmatrix18.repository;

import com.techmatrix18.model.UserActivityStatistic;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

/**
 * Repository for managing UserActivityStatistic entities.
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
public interface UserActivityStatisticRepository extends ReactiveCrudRepository<UserActivityStatistic, Long> {

    // Найти все записи по конкретному пользователю
    Flux<UserActivityStatistic> findAllByUserId(Long userId);

    // Найти все записи за конкретную дату
    Flux<UserActivityStatistic> findAllByDate(LocalDate date);

    // Найти все записи за диапазон дат
    Flux<UserActivityStatistic> findAllByDateBetween(LocalDate startDate, LocalDate endDate);

    // Найти записи по количеству платежей больше указанного
    Flux<UserActivityStatistic> findAllByPaymentsCountGreaterThan(Double paymentsCount);

    // Найти записи по количеству карт больше указанного
    Flux<UserActivityStatistic> findAllByCardsCountGreaterThan(Double cardsCount);

    // Найти записи по общей сумме операций больше указанного значения
    Flux<UserActivityStatistic> findAllByTotalAmountGreaterThan(Double totalAmount);

    // Комбинированный поиск: пользователь + дата
    Flux<UserActivityStatistic> findAllByUserIdAndDate(Long userId, LocalDate date);

    // Комбинированный поиск: пользователь + диапазон дат
    Flux<UserActivityStatistic> findAllByUserIdAndDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
}

