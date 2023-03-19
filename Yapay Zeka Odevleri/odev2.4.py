yas = int(input("Yaşınızı giriniz: "))

if yas < 2:
    print("Bu kişi bebektir")
elif yas <= 4:
    print("Bu kişi yeni yürümeye başlayan çocuktur")
elif yas <= 13:
    print("Bu kişi çocuktur")
elif yas <= 20:
    print("Bu kişi ergendir")
elif yas <= 65:
    print("Bu kişi yetişkindir")
else:
    print("Bu kişi yaşlıdır")
