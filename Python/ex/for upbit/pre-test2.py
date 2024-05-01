def IsPalindromes(texts):
    result = []
    for index in texts:
        ignore = ""
        pal = ""
        for i in range(len(index)):
            if '.' == index[i] or ',' == index[i] or '?' == index[i] or "'" == index[i] or '"' == index[i] or '!' == index[i] or ' ' == index[i]:
                continue
            else:
                ignore = ignore + index[i]
                pal = index[i] + pal

        if ignore.lower() == pal.lower():
            result.append(True)
        else:
            result.append(False)
        print(pal)

    return result
        

texts = ["Madam, I'm Adam.", "rotator", "Hello", "nurses run"]
print(IsPalindromes(texts))