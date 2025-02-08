class Solution {
public:

    static constexpr int B = 250;
    static constexpr int N = 50005 + B;
    static constexpr int Nb = (N + B - 1) / B;
    struct Block{
        int left{B}, right{B}, val{B};
    };

    Block blocks[Nb]{};
    bitset<N> line{};

    vector<bool> getResults(vector<vector<int>>& queries) {

        vector<bool> ret;

        for(auto & q : queries){
            int x = q[1], bIndex = x / B;
            if(q[0] == 1){
                Block& b = blocks[bIndex];
                line[x] = 1;
                int left = bIndex * B, right = (bIndex + 1) * B;
                
                int last = -1;
                b.val = 0;
                for(int i = left; i < right; ++i){
                    if(line[i] == 1){
                        if(last == -1){
                            b.left = i - left;
                            last = left;
                        }
                        b.val = max(b.val, i - last);
                        last = i;
                    }
                }

                b.val = max(b.val, b.right = right - last);
            }else{
                int ans = 0;
                int last_right = 0;
                for(int i = 0; i < bIndex; ++i){
                    ans = max(ans, blocks[i].val);
                    ans = max(ans, blocks[i].left + last_right);

                    if(blocks[i].left == B && blocks[i].right == B){
                        last_right += B;
                    }else{
                        last_right = blocks[i].right;
                    }

                }

                ans = max(ans, last_right + min(blocks[bIndex].left, x - x / B * B ));

                int last = bIndex * B;
                for(int i = last; i <= x; ++i){
                    if(line[i]){
                        ans = max(ans, i - last);
                        last = i;
                    }
                }

                ans = max(ans, x - last);

                ret.emplace_back(ans >= q[2]);
            }

        }

        return ret;

        // [[1,2],[2,3,3],[2,3,1],[2,2,2]]
    }
};