class NumArray {
private:
    vector<int>segment;
    int n;
public:
    NumArray(vector<int>& nums) {
        segment.resize(4 * nums.size()); 
        n = nums.size();
        if(n > 0){
            build(nums, 0, 0, n - 1);
        }
    }
    
    void updateSegmentTree(int pos, int l, int r, int index, int val){
        if(l == r){
            if(l == index){
                segment[pos] = val;
            }
            return;
        }

        if(index < l || index > r) return;

        int mid = (l + r) / 2;
        updateSegmentTree(2 * pos + 1, l, mid, index, val);
        updateSegmentTree(2 * pos + 2, mid + 1, r, index, val);

        segment[pos] = segment[2 * pos + 1] + segment[2 * pos + 2];
    }
    void update(int index, int val) {
        updateSegmentTree(0, 0, n - 1, index, val);
    }

    void build(vector<int>& nums, int idx, int l, int r){
        if(l == r) {
            segment[idx] = nums[l]; return;
        }

        int mid = (l + r)/2;
        build(nums, 2 * idx + 1, l, mid);
        build(nums, 2 * idx + 2, mid + 1, r);
        segment[idx] = segment[2 * idx + 1] + segment[2 * idx + 2];
    }

    int query(int idx, int l, int r, int qi, int qj){
        if(l >= qi && r <= qj) return segment[idx];
        if(qi > r || qj < l) return 0;
        int mid = (l + r)/2;
        int left = query(2 * idx + 1, l , mid, qi, qj);
        int right = query(2* idx + 2, mid + 1, r, qi, qj);
        return left + right;
    }
    
    int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * obj->update(index,val);
 * int param_2 = obj->sumRange(left,right);
 */