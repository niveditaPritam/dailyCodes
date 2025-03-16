class Solution {
public:
    bool isAdditiveNumber(string num) {
        int n = num.size();
        for (int i = 1; i <= n / 2; ++i) {
            for (int j = 1; max(j, i) <= n - i - j; ++j) {
                if (isValid(num, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

private:
    bool isValid(string num, int i, int j) {
        if (num[0] == '0' && i > 1) return false;
        if (num[i] == '0' && j > 1) return false;

        long long num1 = stoll(num.substr(0, i));
        long long num2 = stoll(num.substr(i, j));
        string remaining = num.substr(i + j);

        while (!remaining.empty()) {
            long long sum = num1 + num2;
            string sumStr = to_string(sum);

            if (remaining.rfind(sumStr, 0) != 0) {
                return false;
            }

            remaining = remaining.substr(sumStr.size());
            num1 = num2;
            num2 = sum;
        }
        return true;
    }
};
