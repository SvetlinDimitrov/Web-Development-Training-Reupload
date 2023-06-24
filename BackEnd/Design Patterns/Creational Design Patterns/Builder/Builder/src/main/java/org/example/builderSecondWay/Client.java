package org.example.builderSecondWay;

public class Client {
    public static void main(String[] args) {
        AddressDto addressDto = new AddressDto("levada" , "bulgaria" , "1235");
        Address address = directBuild(new BuilderAddressImp() , addressDto);
        System.out.println(address);
    }

    private static Address directBuild(BuilderAddress builder, AddressDto addressDto) {
        return builder.setCountry(addressDto.getCountry())
                .setTown(addressDto.getTown())
                .setZipCode(addressDto.getZipCode())
                .build();
    }
}
