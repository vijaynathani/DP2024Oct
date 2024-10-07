class TelNo {
    String countryCode, areaCode, localNumber;
}
class Name {
    String first, last;
}
class Person {
    Name english, chinese;
    TelNo landLine, fax, mobile;
}
class Organization {
    String id;
    String englishName, chineseName;
    TelNo primaryVoice, faxNo;
    Person contact;
    ...
}
