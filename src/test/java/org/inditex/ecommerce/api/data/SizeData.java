package org.inditex.ecommerce.api.data;

import org.iditex.ecommerce.model.entities.Size;
import org.inditex.ecommerce.api.persistence.entities.SizeDto;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SizeData {

    public static final Map<Long, Size> SIZES = Stream.of(
            new Size(11L, 1L, true, false, StockData.STOCKS.get(11L)),
            new Size(12L, 1L, false, false, StockData.STOCKS.get(12L)),
            new Size(13L, 1L , true, false, StockData.STOCKS.get(13L)),
            new Size(21L, 2L, false, false, StockData.STOCKS.get(21L)),
            new Size(22L, 2L, false, false, StockData.STOCKS.get(22L)),
            new Size(23L, 2L, true, true, StockData.STOCKS.get(23L)),
            new Size(31L, 3L, true, false, StockData.STOCKS.get(31L)),
            new Size(32L, 3L, true, false, StockData.STOCKS.get(32L)),
            new Size(33L, 3L, false, false, StockData.STOCKS.get(33L)),
            new Size(41L, 4L, false, false, StockData.STOCKS.get(41L)),
            new Size(42L, 4L, false, false, StockData.STOCKS.get(42L)),
            new Size(43L, 4L, false, false, StockData.STOCKS.get(43L)),
            new Size(44L, 4L, true, true, StockData.STOCKS.get(44L)),
            new Size(51L, 5L, true, false, StockData.STOCKS.get(51L)),
            new Size(52L, 5L, false, false, StockData.STOCKS.get(52L)),
            new Size(53L, 5L, false, false, StockData.STOCKS.get(53L)),
            new Size(54L, 5L, true, true, StockData.STOCKS.get(54L))
    ).collect(Collectors.groupingBy(Size::getId, Collectors.collectingAndThen(Collectors.toList(), list -> list.get(0))));

    public static final Map<Long, SizeDto> DTO = Stream.of(
            new SizeDto(11L, 1L, true, false, StockData.DTO.get(11L)),
            new SizeDto(12L, 1L, false, false, StockData.DTO.get(12L)),
            new SizeDto(13L, 1L , true, false, StockData.DTO.get(13L)),
            new SizeDto(21L, 2L, false, false, StockData.DTO.get(21L)),
            new SizeDto(22L, 2L, false, false, StockData.DTO.get(22L)),
            new SizeDto(23L, 2L, true, true, StockData.DTO.get(23L)),
            new SizeDto(31L, 3L, true, false, StockData.DTO.get(31L)),
            new SizeDto(32L, 3L, true, false, StockData.DTO.get(32L)),
            new SizeDto(33L, 3L, false, false, StockData.DTO.get(33L)),
            new SizeDto(41L, 4L, false, false, StockData.DTO.get(41L)),
            new SizeDto(42L, 4L, false, false, StockData.DTO.get(42L)),
            new SizeDto(43L, 4L, false, false, StockData.DTO.get(43L)),
            new SizeDto(44L, 4L, true, true, StockData.DTO.get(44L)),
            new SizeDto(51L, 5L, true, false, StockData.DTO.get(51L)),
            new SizeDto(52L, 5L, false, false, StockData.DTO.get(52L)),
            new SizeDto(53L, 5L, false, false, StockData.DTO.get(53L)),
            new SizeDto(54L, 5L, true, true, StockData.DTO.get(54L))
    ).collect(Collectors.groupingBy(SizeDto::getId, Collectors.collectingAndThen(Collectors.toList(), list -> list.get(0))));

    public static Set<Size> findByProductId(Long id) {
        return SIZES.values().stream().filter(size -> size.getProductId().equals(id)).collect(Collectors.toSet());
    }

    public static List<SizeDto> findDtoByProductId(Long id) {
        return DTO.values().stream().filter(size -> size.getProductId().equals(id)).collect(Collectors.toList());
    }

}
