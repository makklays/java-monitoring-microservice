package com.techmatrix18.repository;

import com.techmatrix18.model.MerchantStatistic;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

/**
 * Repository for managing MerchantStatistic entities.
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
public interface MerchantStatisticRepository extends ReactiveCrudRepository<MerchantStatistic, Long> {

    // Найти все статистики по конкретному торговцу
    Flux<MerchantStatistic> findAllByMerchantId(Long merchantId);

    // Найти все записи за конкретную дату
    Flux<MerchantStatistic> findAllByDate(LocalDate date);

    // Найти все записи за диапазон дат
    Flux<MerchantStatistic> findAllByDateBetween(LocalDate startDate, LocalDate endDate);

    // Найти статистику по категории товаров или услуг
    Flux<MerchantStatistic> findAllByCategory(String category);

    // Комбинированный поиск: торговец + дата
    Flux<MerchantStatistic> findAllByMerchantIdAndDate(Long merchantId, LocalDate date);

    // Комбинированный поиск: торговец + дата + категория
    Flux<MerchantStatistic> findAllByMerchantIdAndDateAndCategory(Long merchantId, LocalDate date, String category);
}

