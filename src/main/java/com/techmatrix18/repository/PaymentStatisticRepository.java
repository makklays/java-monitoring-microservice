package com.techmatrix18.repository;

import com.techmatrix18.model.PaymentStatistic;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

/**
 * Repository for managing PaymentStatistic entities.
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
public interface PaymentStatisticRepository extends ReactiveCrudRepository<PaymentStatistic, Long> {

    // Найти все записи за конкретную дату
    Flux<PaymentStatistic> findAllByDate(LocalDate date);

    // Найти записи за диапазон дат
    Flux<PaymentStatistic> findAllByDateBetween(LocalDate startDate, LocalDate endDate);

    // Найти записи по типу платежа (SEPA, BIZUM, INTERNAL и т.д.)
    Flux<PaymentStatistic> findAllByPaymentType(String paymentType);

    // Найти записи по статусу платежа (SUCCESS, FAILED)
    Flux<PaymentStatistic> findAllByStatus(String status);

    // Найти записи по валюте
    Flux<PaymentStatistic> findAllByCurrencyCode(String currencyCode);

    // Комбинированный поиск: дата + тип платежа
    Flux<PaymentStatistic> findAllByDateAndPaymentType(LocalDate date, String paymentType);

    // Комбинированный поиск: дата + тип платежа + статус
    Flux<PaymentStatistic> findAllByDateAndPaymentTypeAndStatus(LocalDate date, String paymentType, String status);
}

