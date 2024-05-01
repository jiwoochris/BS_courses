def FindBalance(nums):
    for i in range(len(nums)):
        if sum(nums[:i]) == sum(nums[i+1:]):
            index = i

    return [index, nums[index], sum(nums[:index])]

print(FindBalance([1,2,3,4,5,2,3,5]))