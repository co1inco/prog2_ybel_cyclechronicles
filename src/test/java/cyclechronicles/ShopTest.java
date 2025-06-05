package cyclechronicles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;


public class ShopTest {

    private final String _dummyCustomer = "Dummy";

    @BeforeEach
    public void Initialize() {

    }


    @Test
    public void ValidBikeType() {

        // Arrange
        for (var type : Type.class.getEnumConstants()) {
            var order = CreateOrderMock(_dummyCustomer, type);

            var shop = new Shop();

            //Act
            var result = shop.accept(order);

            //Assert
            switch (type) {
                case RACE, FIXIE, SINGLE_SPEED -> {
                    assertTrue(result);
                }
                case GRAVEL, EBIKE -> {
                    assertFalse(result);
                }
                default -> throw new UnsupportedOperationException("Bike type " + type + " is not tested");

            }
        }
    }

    @Test
    public void CustomerHasOrder_ShouldFail() throws Exception {
        //Arrange
        var secondOrder = CreateOrderMock(_dummyCustomer, Type.SINGLE_SPEED);
        var shop = new Shop();
        if (!shop.accept(secondOrder))
            throw new Exception("Failed to accept valid order");

        var order = CreateOrderMock(_dummyCustomer, Type.RACE);

        //Act
        var result = shop.accept(order);

        //Assert
        assertFalse(result);
    }

    @Test
    public void ShopHas5PendingOrders_ShouldFail() throws Exception{
        //Arrange
        var shop = new Shop();
        for (int i = 0; i < 5; i++) {
            var pendingOrder = CreateOrderMock(Integer.toString(i), Type.SINGLE_SPEED);
            if (!shop.accept(pendingOrder))
                throw new Exception("Failed to accept valid order");
        }

        var order = CreateOrderMock(_dummyCustomer, Type.RACE);

        //Act
        var result = shop.accept(order);

        //Assert
        assertFalse(result);
    }

    @Test
    public void ShopHas4PendingOrders_ShouldSucceed() throws Exception{
        //Arrange
        var shop = new Shop();
        for (int i = 0; i < 4; i++) {
            var pendingOrder = CreateOrderMock(Integer.toString(i), Type.SINGLE_SPEED);
            if (!shop.accept(pendingOrder))
                throw new Exception("Failed to accept valid order");
        }

        var order = CreateOrderMock(_dummyCustomer, Type.RACE);

        //Act
        var result = shop.accept(order);

        //Assert
        assertTrue(result);
    }


    private Order CreateOrderMock(String customer, Type bikeType) {
        var order = Mockito.mock(Order.class);
        Mockito.when(order.getCustomer()).thenReturn(customer);
        Mockito.when(order.getBicycleType()).thenReturn(bikeType);
        return order;
    }
}
