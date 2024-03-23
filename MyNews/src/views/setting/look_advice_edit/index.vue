<template>
  <div>
    <Header title="未读建议列表"></Header>
    <ul class="unread-list">
      <li v-for="(advice, index) in unreadSuggestions" :key="index" @click="goToDetail(advice)">
        <div class="list-item">
          {{ advice.suggestion.slice(0, 18) }}
        </div>
      </li>
    </ul>
  </div>
</template>
<script>
import axios from 'axios';
import Header from '@/components/Header.vue';
export default {
  components: { 
    Header
  },
  data() {
    return {
      unreadSuggestions: [],
    };
  },
  methods: {
    goToDetail(advice) {
      this.$router.push({ path: `/adviceDetail/${advice.id}` });
    },
    fetchUnreadSuggestions() {
      axios.get('http://localhost:9090/sug/unread')
        .then(response => {
          this.unreadSuggestions = response.data.filter(advice => advice.suggestion.trim() !== '');
        })
        .catch(error => {
          console.error('读取失败', error);
        });
    },
  },
  mounted() {
    this.fetchUnreadSuggestions();
  },
};
</script>

<style scoped>
.unread-list {
  list-style: none;
  padding: 0;
}

.list-item {
  padding: 4px;
  font-size: 6px; /* 调整字体大小 */
  border-bottom: 1px solid #eee;
}
</style>
